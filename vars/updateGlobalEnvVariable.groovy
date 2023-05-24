@NonCPS
def call(String globVarName, globVarValue) {
       instance = Jenkins.get()
       def globalNodeProperties = instance.getGlobalNodeProperties()
       def envVarsNodePropertyList = globalNodeProperties.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)

       def newEnvVarsNodeProperty = null
       def envVars = null

       if ( envVarsNodePropertyList == null || envVarsNodePropertyList.size() == 0 ) {
           newEnvVarsNodeProperty = new hudson.slaves.EnvironmentVariablesNodeProperty();
           globalNodeProperties.add(newEnvVarsNodeProperty)
           envVars = newEnvVarsNodeProperty.getEnvVars()
       } else {
           envVars = envVarsNodePropertyList.get(0).getEnvVars()
       }

       envVars.put(globVarName, globVarValue)
       instance.save()
}
