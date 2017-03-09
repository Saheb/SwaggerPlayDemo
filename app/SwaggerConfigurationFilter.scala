import java.util

import io.swagger.core.filter.SwaggerSpecFilter
import io.swagger.model.ApiDescription
import io.swagger.models.{Model, Operation}
import io.swagger.models.parameters.Parameter
import io.swagger.models.properties.Property

class SwaggerConfigurationFilter extends SwaggerSpecFilter {

  override def isParamAllowed(
                               parameter: Parameter,
                               operation: Operation,
                               api: ApiDescription,
                               params: util.Map[String, util.List[String]],
                               cookies: util.Map[String, String],
                               headers: util.Map[String, util.List[String]]
                             ): Boolean = true

  override def isPropertyAllowed(
                                  model: Model,
                                  property: Property,
                                  propertyName: String,
                                  params: util.Map[String, util.List[String]],
                                  cookies: util.Map[String, String],
                                  headers: util.Map[String, util.List[String]]
                                ): Boolean = if (property.getName == "id") false else true

  override def isOperationAllowed(
                                   operation: Operation,
                                   api: ApiDescription,
                                   params: util.Map[String, util.List[String]],
                                   cookies: util.Map[String, String],
                                   headers: util.Map[String, util.List[String]]
                                 ): Boolean = true
}
