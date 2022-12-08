import sys

from PyQt5.QtCore import Qt, QTimer
from PyQt5.QtWidgets import QApplication, QDial, QMainWindow


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.dial = QDial()
        self.dial.setRange(0, 100)
        self.dial.setValue(0)

        self.timer = QTimer()
        self.timer.setInterval(10)
        self.timer.timeout.connect(self.update_dial)
        # tag::timertype[]
        self.timer.setTimerType(Qt.PreciseTimer)
        # end::timertype[]
        self.timer.start()

        self.setCentralWidget(self.dial)

    def update_dial(self):
        value = self.dial.value()
        value += 1  # increment
        if value > 100:
            value = 0
        self.dial.setValue(value)


app = QApplication(sys.argv)
w = MainWindow()
w.show()

app.exec_()
