from PyQt5.QtWidgets import QMainWindow, QApplication, QPushButton
from PyQt5.QtGui import QIcon
import sys, os

basedir = os.path.dirname(__file__)


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Hello World")

        button = QPushButton("My simple app.")
        button.setIcon(
            QIcon(os.path.join(basedir, "icons", "lightning.svg"))
        )
        button.pressed.connect(self.close)

        self.setCentralWidget(button)

        self.show()


app = QApplication(sys.argv)
app.setWindowIcon(QIcon(os.path.join(basedir, "icons", "icon.svg")))
w = MainWindow()
app.exec_()
