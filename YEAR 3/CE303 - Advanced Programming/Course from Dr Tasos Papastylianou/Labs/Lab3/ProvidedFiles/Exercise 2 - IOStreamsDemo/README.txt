Run this using a pipe, e.g.

    java Say | java Main up


On windows you may have to specify the classpath explicitly, i.e.

    java -cp . Say | java -cp . Main up

Also note that on windows, depending on your keyboard, your keyboard may produce a '¦' character instead of '|'.
Only the latter will work as a pipe, the former will not. Copy from here if necessary.
