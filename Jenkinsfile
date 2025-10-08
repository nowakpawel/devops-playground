// Jenkinsfile - checks for gcc
pipeline {
	agent {
		docker {
			image 'maven:3.9.4-eclipse-temurin-17'
			args '-v /root/.m2:/root/.m2'
		}
	}
	
	stages {
		stage('Checkout') {
			steps { 
				checkout scm 
			}
		}

		stage('Build & Test') {
			steps {
				dir('backend') {
					script {
						if (env.BRANCH_NAME == 'main') {
							sh 'mvn -B clean package -DskipTests'
						} else {
							sh 'mvn -B clean verify -Dspring.profiles.active=test'
						}
					}
				}
			}
		}

		stage('Archive Artifact if main') {
			when { 
				branch "main"
			}

			steps {
				dir('backend') {
					archiveArtifacts artifacts: 'target/*.jar', fingerprint: true 
					echo "Artifact built successfully"
				}
			}
		}
	}

	post {
		always {
			echo "Pipeline finished for branch ${env.BRANCH_NAME}"
		}
	}
}

