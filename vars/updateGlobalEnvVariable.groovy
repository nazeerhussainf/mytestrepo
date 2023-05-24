def call(String globVarName, globVarValue) {
  node {
       instance = Jenkins.get()
       def globalNodeProperties = instance.getGlobalNodeProperties()
       def envVarsNodePropertyList = globalNodeProperties.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)

       def newEnvVarsNodeProperty = null
       def envVars = null

       if ( envVarsNodePropertyList == null || envVarsNodePropertyList.size() == 0 ) {
           def newEnvVarsNodeProperty = new hudson.slaves.EnvironmentVariablesNodeProperty();
           globalNodeProperties.add(newEnvVarsNodeProperty)
           def envVars = newEnvVarsNodeProperty.getEnvVars()
       } else {
           def envVars = envVarsNodePropertyList.get(0).getEnvVars()
       }

       envVars.put(globVarName, globVarValue)
       instance.save()

  }
}
