grails.project.work.dir = "target"

grails.project.dependency.resolution = {
	inherits("global") {
		excludes 'tomcat'
		excludes 'hibernate'
	}

	log "warn"

	repositories {
		grailsPlugins()
		grailsHome()
		grailsCentral()

		mavenLocal()
		mavenCentral()
	}

	dependencies {
		compile('org.apache.camel:camel-core:2.10.4')
		compile('org.apache.camel:camel-spring:2.10.4') {
			excludes 'spring-aop', 'spring-beans', 'spring-core', 'spring-expression', 'spring-asm', 'spring-tx', 'spring-context'
		}
		compile('org.apache.camel:camel-groovy:2.10.4') {
			excludes 'spring-context', 'spring-aop', 'spring-tx', 'groovy-all'
		}
		compile('org.apache.camel:camel-stream:2.10.3')
	}

	plugins {
		build(":release:2.2.0", ':rest-client-builder:1.0.3') { export = false }
	}
}
