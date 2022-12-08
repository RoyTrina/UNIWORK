import sys
import time

from PyQt5.QtCore import QThread, pyqtSignal, pyqtSlot
from PyQt5.QtWidgets import (
    QApplication,
    QLabel,
    QMainWindow,
    QPushButton,
    QSpinBox,
    QVBoxLayout,
    QWidget,
)


class Thread(QThread):
    """
    Worker thread
    """

    result = pyqtSignal(str)

    @pyqtSlot()
    def run(self):
        """
        Your code goes in this method
        """
        self.data = None
        self.is_running = True
        print("Thread start")
        counter = 0
        while self.is_running:
            time.sleep(0.1)
            # Output the number as a formatted string.
            self.result.emit(f"The number is {counter}")
            counter += 1

    def stop(self):
        self.is_running = False




class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        # Create thread and start it.
        self.thread = Thread()
        self.thread.start()

        label = QLabel("Output will appear here")
        # tag::stop[]
        button = QPushButton("Shutdown thread")
        # Shutdown the thread nicely.
        button.pressed.connect(self.thread.stop)
        # end::stop[]

        # Connect signal, so output appears on label.
        self.thread.result.connect(label.setText)
        self.thread.finished.connect(self.thread_has_finished)

        container = QWidget()
        layout = QVBoxLayout()
        layout.addWidget(label)
        layout.addWidget(button)
        container.setLayout(layout)

        self.setCentralWidget(container)
        self.show()

    # tag::thread_has_finished[]
    def thread_has_finished(self):
        print("Thread has finished.")
        print(
            self.thread,
            self.thread.isRunning(),
            self.thread.isFinished(),
        )

    # end::thread_has_finished[]


app = QApplication(sys.argv)
window = MainWindow()
app.exec_()
