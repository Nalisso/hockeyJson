
ParseTest:
	mvn clean dependency:copy-dependencies package
	java -cp target/hockey-1.0-SNAPSHOT.jar:target/dependency/*  hockey.ParseTest

test-json:
	(cd go && make test-json)
