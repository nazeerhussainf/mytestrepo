def call(globVarName, globVarValue) {
  node {
       def globalNodeProperties = Jenkins.getInstance().getGlobalNodeProperties()
       def envVarsNodePropertyList = globalNodeProperties.getAll(hudson.slaves.EnvironmentVariablesNodeProperty.class)
       if (envVarsNodePropertyList == null || envVarsNodePropertyList.size() == 0) {
           def envVarsNodePropertyClass = this.class.classLoader.loadClass('hudson.slaves.EnvironmentVariablesNodeProperty')
           globalNodeProperties.add(envVarsNodePropertyClass.newInstance())
       }
       envVarsNodePropertyList.get(0).getEnvVars().put(globVarName, globVarValue)
       
  }
}
