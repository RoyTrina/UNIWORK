from PyQt5.QtWidgets import QApplication, QLabel
from PyQt5.QtGui import QPalette, QColor
from PyQt5.QtCore import Qt

import sys


app = QApplication(sys.argv)
palette = QPalette()
palette.setColor(QPalette.Window, QColor(0, 128, 255))
palette.setColor(QPalette.WindowText, Qt.white)
app.setPalette(palette)

w = QLabel("Palette Test")
w.show()

app.exec_()
