// Jenkinsfile - checks for gcc
pipeline {
	agent any
	
	stages {
		stage('Checkout') {
			steps { checkout scm }
		}

		stage('Install deps (if needed)') {
			steps {
				sh '''
					if command -v apt-get > /dev/null 2>&1; then
						echo "Installing built-essential..."
						# sudo may be needed depending on container

						apt-get update || true
						apt-get install -y built-essential || true
					else
						echo "apt-get not found - ensure build tools are installed or use Focker agent"
					fi
				'''
			}
		}

		stage('Build') {
			steps {
				sh 'gcc -Wall -Wextra -std=c11 -O2 -o app main.c'
			}
		}

		stage('Test') {
			steps {
				sh './test.sh'
			}
		}

		stage('Archive if main') {
			when { expression {env.BRANCH_NAME == 'main'} }
			steps { archiveArtifacts artifacts: 'app', fingerprint: true }
		}
	}

	post {
		always {
			echo "Pipeline finished for branch ${env.BRANCH_NAME}"
		}
	}

