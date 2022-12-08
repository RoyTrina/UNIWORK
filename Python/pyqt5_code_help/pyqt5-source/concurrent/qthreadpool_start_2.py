import sys
import time

from PyQt5.QtCore import (
    QRunnable,
    QThreadPool,
    QTimer,
    pyqtSlot,
    pyqtSignal,
)
from PyQt5.QtWidgets import (
    QApplication,
    QLabel,
    QMainWindow,
    QPushButton,
    QVBoxLayout,
    QWidget,
)


class MainWindow(QMainWindow):

    custom_signal = pyqtSignal()

    def __init__(self):
        super().__init__()

        # Connect our custom signal to a handler.
        self.custom_signal.connect(self.signal_handler)
        # etc.

        # end::custom_signal[]

        self.threadpool = QThreadPool()
        print(
            "Multithreading with maximum %d threads"
            % self.threadpool.maxThreadCount()
        )

        self.counter = 0

        layout = QVBoxLayout()

        self.l = QLabel("Start")
        b = QPushButton("DANGER!")
        b.pressed.connect(self.oh_no)

        layout.addWidget(self.l)
        layout.addWidget(b)

        w = QWidget()
        w.setLayout(layout)

        self.setCentralWidget(w)

        self.show()

        self.timer = QTimer()
        self.timer.setInterval(1000)
        self.timer.timeout.connect(self.recurring_timer)
        self.timer.start()

    # tag::do_some_work[]
    def oh_no(self):
        self.threadpool.start(self.do_some_work)

    @pyqtSlot()
    def do_some_work(self):
        print("Thread start")
        # Emit our custom signal.
        self.custom_signal.emit()
        for n in range(5):
            time.sleep(1)
        self.counter = self.counter - 10
        print("Thread complete")

    def signal_handler(self):
        print("Signal received!")

    def recurring_timer(self):
        self.counter += 1
        self.l.setText("Counter: %d" % self.counter)

    # end::do_some_work[]


app = QApplication(sys.argv)
window = MainWindow()
app.exec_()
