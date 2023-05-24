def call(Map message1, message2) {
  node {
    echo "${message1}"
    echo "${message2}"
  }
}
