1.Update pom.xml for version number
	<version>1.0.2</version>

2.Run the maven clean command
	mvn clean

3.Run the maven package command
	mvn package

4.Run the maven assembly command
	mvn assembly:single

A zip archive will be created in the target directory that can be used for distribution.