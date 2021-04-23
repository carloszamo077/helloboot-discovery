node("mavenwithnexus") {
  checkout scm

  stage("Test") {
    sh "mvn -B -Popenshift test"
  }

  stage("Deploy") {
    sh "mvn  -Popenshift -DskipTests clean fabric8:deploy"
  }
}
