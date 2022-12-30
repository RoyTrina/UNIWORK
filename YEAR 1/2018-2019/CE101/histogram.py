"""
program to generate a histogram from data
created by tr17548
taken information from http://www.learningaboutelectronics.com/Articles/How-to-create-a-histogram-in-matplotlib-with-Python.php
"""
import random
import matplotlib.pyplot as plt


testscores = random.sample(range(99),21)

bins = [30, 40, 50, 60, 70, 80, 90, 100]

plt.hist(testscores, bins, histtype = 'bar', rwidth = 0.8)

plt.show()
