package api;

import api.dto.ErrorResponse;
import api.dto.FinishRequest;
import api.parameters.ErrorOption;
import api.parameters.OpenapiConstants;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Tag(name = "Callback endpoint")
@Path("/rest/callback")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SomeEndpoint {

    String FINISH_TASK = "/{taskName}/finish";
    @Path(FINISH_TASK)
    @Operation(summary = "[ADMIN] Used by remote entity to report Task completion.")
    @APIResponses(value = {
            @APIResponse(responseCode = OpenapiConstants.SUCCESS_CODE, description = OpenapiConstants.SUCCESS_DESCRIPTION),
            @APIResponse(responseCode = OpenapiConstants.INVALID_CODE, description = OpenapiConstants.INVALID_DESCRIPTION,
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(responseCode = OpenapiConstants.SERVER_ERROR_CODE, description = OpenapiConstants.SERVER_ERROR_DESCRIPTION,
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @POST
    @Deprecated
    void finish(@PathParam("taskName") @NotEmpty String taskName,
                @Valid @NotNull FinishRequest result,
                @QueryParam("err") @DefaultValue("PASS_ERROR") ErrorOption err);

    String OPERATION_SUCCESSFUL = "/{taskName}/succeed";
    @Path(OPERATION_SUCCESSFUL)
    @Operation(summary = "[ADMIN] Used by remote entity to report successful Task completion.")
    @APIResponses(value = {
            @APIResponse(responseCode = OpenapiConstants.SUCCESS_CODE, description = OpenapiConstants.SUCCESS_DESCRIPTION),
            @APIResponse(responseCode = OpenapiConstants.INVALID_CODE, description = OpenapiConstants.INVALID_DESCRIPTION,
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(responseCode = OpenapiConstants.SERVER_ERROR_CODE, description = OpenapiConstants.SERVER_ERROR_DESCRIPTION,
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @POST
    void succeed(@PathParam("taskName") @NotEmpty String taskName,
                 Object result,
                 @QueryParam("err") @DefaultValue("PASS_ERROR") ErrorOption err);
}
