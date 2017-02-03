name := "assembly-shade-example"

organization := "com.github.damdev"

assemblyShadeRules in assembly := Seq(
  ShadeRule.rename("net.bytebuddy.**" -> "agent.libs.@0").inAll,
  ShadeRule.rename("ch.qos.logback.core.**" -> "agent.libs.@0").inAll,
  ShadeRule.rename("ch.qos.logback.classic.**" -> "agent.libs.@0").inAll,
  ShadeRule.rename("org.slf4j.**" -> "agent.libs.@0").inAll
)

libraryDependencies ++= Seq(
	"ch.qos.logback"            % "logback-core"            % "1.0.13"
)

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false, includeDependency = true, includeBin = true)