# test-surefire
The illustration of an integration error when using surefire-junit47 and JUnitParams

1. Just run command from command line: `mvn test > mvn.log`
2. See the log file
3. Remove the explicit use of the surefire-junit47 provider to use the default provider. To do this, comment out the corresponding section dependencies
```
<!--
                    <dependencies>
                        <dependency>
                            <groupId>org.apache.maven.surefire</groupId>
                            <artifactId>surefire-junit47</artifactId>
                            <version>${maven-surefire-plugin.version}</version>
                        </dependency>
                    </dependencies>
-->
```
4. Run `mvn test` again and make sure there is no error
