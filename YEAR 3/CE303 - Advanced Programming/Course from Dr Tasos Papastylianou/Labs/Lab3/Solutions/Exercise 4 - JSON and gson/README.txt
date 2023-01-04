Note that to compile, you will need both junit.jar and gson.jar in your class path:

    javac -cp .:gson.jar:junit.jar TestStudentJSON.java

Then, when running the tests via junit.jar, you will need to add gson.jar in your classpath:

    java -jar junit.jar -cp .:gson.jar --select-class TestStudentJSON

