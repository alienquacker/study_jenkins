def host = 'localhost'
pipeline {
    agent{node('master')}
    stages {
    stage ('Download from git'){
        checkout([$class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'RelativeTargetDirectory',
                    relativeTargetDir: 'auto']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'AZGit',url: 'https://github.com/alienquacker/study_jenkins.git']]])
                
      }
        
       
    }
    }
}
