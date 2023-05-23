def call(globVarName, globVarValue) {
  node {
       instance = Jenkins.get()
       globalNodeProperties = instance.getGlobalNodeProperties()
       envVarsNodePropertyList = globalNodeProperties.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)

       newEnvVarsNodeProperty = null
       envVars = null

       if ( envVarsNodePropertyList == null || envVarsNodePropertyList.size() == 0 ) {
           newEnvVarsNodeProperty = new hudson.slaves.EnvironmentVariablesNodeProperty();
           globalNodeProperties.add(newEnvVarsNodeProperty)
           envVars = newEnvVarsNodeProperty.getEnvVars()
       } else {
           envVars = envVarsNodePropertyList.get(0).getEnvVars()
       }

       envVars.put("VM_STATUS", "FAILED")
       instance.save()
  }
}
