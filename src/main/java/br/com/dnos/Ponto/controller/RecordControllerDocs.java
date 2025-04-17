package br.com.dnos.Ponto.controller;

import br.com.dnos.Ponto.controller.request.RecordRequest;
import br.com.dnos.Ponto.controller.response.RecordResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Record", description = "Ponto records routes")
@SecurityRequirement(name = "Bearer Authentication")
public interface RecordControllerDocs {

    @Operation(summary = "Create a record for the logged user")
    @ApiResponses(value =
            @ApiResponse(
                    responseCode = "200",
                    description = "Created a new record",
                    content = @Content(
                            schema = @Schema(implementation = RecordResponse.class)
                    )
            )
    )
    public RecordResponse createRecord(
            @RequestBody(
                    content = @Content(
                            schema = @Schema(implementation = RecordRequest.class)
                    )
            )
            RecordRequest data
    );
}
