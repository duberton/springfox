package com.mangofactory.documentation.swagger.mixins
import com.fasterxml.classmate.TypeResolver
import com.mangofactory.documentation.schema.configuration.ModelsConfiguration
import com.mangofactory.documentation.swagger.configuration.SwaggerSpringMvcDocumentationConfiguration
import com.mangofactory.documentation.spi.service.contexts.Defaults
import com.mangofactory.documentation.spring.web.mixins.ModelProviderForServiceSupport

import javax.servlet.ServletContext

@Mixin([ModelProviderForServiceSupport, MapperSupport])
@SuppressWarnings("GrMethodMayBeStatic")
class SpringSwaggerConfigSupport {

  def SwaggerSpringMvcDocumentationConfiguration springSwaggerConfig() {
    new SwaggerSpringMvcDocumentationConfiguration()
  }

  def Defaults defaults(ServletContext servletContext) {
    def typeResolver = new TypeResolver()
    def modelConfig = new ModelsConfiguration()
    def alternateTypeProvider = modelConfig.alternateTypeProvider(typeResolver)
    new Defaults(servletContext, typeResolver, alternateTypeProvider)
  }
}