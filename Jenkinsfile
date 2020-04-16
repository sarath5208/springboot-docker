pipeline
{
    agent any
    environment {
        //Use Nexus registry
        registry = "https://********/springboot"
        imageTag="pres2/springboot"
        registryCredential = "******"
    }
 tools
   {
       maven 'Maven'
   }

     parameters
     {
        string(name: 'DEV_HOSTNAME', defaultValue: 'server.com', description: 'PRES Dev Server')
        string(name: 'USERNAME', defaultValue: 'jaddap2', description: 'USERNAME')
      }

     stages
     {
       stage('Build WAR file')
       {
        agent any
          steps
            {
              configFileProvider([configFile(fileId:'nexus-maven-releases-repo', variable: 'MAVEN_SETTINGS')])
             {
                 sh 'mvn clean package  -s $MAVEN_SETTINGS -DskipTests=true'
             }
           }
       }

       stage('Build docker image')
       {
        agent any
          steps
            {
              echo "Inside Build the App"
              script
              {
				docker.withRegistry(registry, registryCredential )
              	{
                 	dockerImage=docker.build(imageTag+":${env.BUILD_ID}")
               	}
              }
           }
       }

      stage('Push Image')
      {
        agent any
        steps
        {
           script
            {
              docker.withRegistry(registry, registryCredential )
              {
                 dockerImage.push()
               }

              }//End of script
        } //End of steps
       }

       stage('Cleanup')
       {
         steps
         {
           //sh "docker system prune -f"
			echo "Pushed image"
         }
       }

    } //End of stages

} //End of pipeline
