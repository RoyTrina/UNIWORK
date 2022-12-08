import os
import sys

from PyQt5 import QtWidgets, uic

basedir = os.path.dirname(__file__)

app = QtWidgets.QApplication(sys.argv)

window = uic.loadUi(os.path.join(basedir, "mainwindow.ui"))
window.show()
app.exec_()
