// Jenkins Job DSL to create Jobs

//Base Path For All Jobs Related to this project
def basePath = 'HorseflyProject';

//Folder already exists. Seed job inside of it
folder (basePath) {
  displayName('HorseflyProject');
  description('Folder for HorseflyProject');
}


//Git repository for horsefly-userportal
def repoUrl = "https://github.com/thevictorgreen/horsefly-userportal.git"; //Repository UrL

pipelineJob(basePath + "/horsefly-userportal") { //JobName
  description("Application frontend for the user portal");
  definition {
    cpsScm {
      scriptPath("Jenkinsfile"); //Path to Build Script
      scm {
        git {
          remote {
            url(repoUrl); //Git Repository
            branch("master");
          }
        }
      }
      triggers {
        githubPush();
      }
    }
  }
}


