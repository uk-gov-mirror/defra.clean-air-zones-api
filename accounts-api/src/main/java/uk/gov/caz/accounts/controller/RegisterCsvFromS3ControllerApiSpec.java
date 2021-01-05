package uk.gov.caz.accounts.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import uk.gov.caz.accounts.configuration.SwaggerConfiguration;
import uk.gov.caz.accounts.dto.RegisterCsvFromS3JobHandle;
import uk.gov.caz.accounts.dto.StartRegisterCsvFromS3JobCommand;
import uk.gov.caz.accounts.dto.StatusOfRegisterCsvFromS3JobQueryResult;
import uk.gov.caz.correlationid.Constants;

/**
 * Rest controller specification related to registering VRNs of a fleet account from CSV file
 * located on AWS S3 into the database.
 */
@Api(tags = {SwaggerConfiguration.TAG_REGISTER_CSV_FROM_S3_CONTROLLER})
@RequestMapping(value = RegisterCsvFromS3Controller.PATH)
public interface RegisterCsvFromS3ControllerApiSpec {

  /**
   * Request to start a job that registers VRNs of a given fleet account. Source will be CSV file
   * located on AWS S3.
   *
   * @param correlationId CorrelationID to track the request from the API gateway through the
   *     Enquiries stack
   * @param startRegisterCsvFromS3JobCommand command with S3 Bucket and filename
   * @return A handle which uniquely identifies register job that has been started
   */
  @ApiOperation(
      value = "Request to start register job. Source will be CSV file located on AWS S3",
      response = RegisterCsvFromS3JobHandle.class
  )
  @ApiResponses({
      @ApiResponse(code = 500, message = "Internal Server Error / No message available"),
      @ApiResponse(code = 400, message = "Correlation Id missing"),
      @ApiResponse(code = 406, message = "Previous job has not finished yet"),
      @ApiResponse(code = 201, message = "Returns a 'jobName', which is a handle that uniquely "
          + "identifies register job that has been started"),
  })
  @ApiImplicitParams({
      @ApiImplicitParam(name = Constants.X_CORRELATION_ID_HEADER,
          required = true,
          value = "CorrelationID to track the request from the API gateway through"
              + " the Enquiries stack",
          paramType = "header")
  })
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.CREATED)
  ResponseEntity<RegisterCsvFromS3JobHandle> startRegisterJob(
      @RequestHeader(Constants.X_CORRELATION_ID_HEADER) String correlationId,
      @RequestBody StartRegisterCsvFromS3JobCommand startRegisterCsvFromS3JobCommand);

  /**
   * Gets status of register job identified by name. Can be used from polling mechanism to check
   * whether registering job has finished and if there were any errors.
   *
   * @param correlationId CorrelationID to track the request from the API gateway through the
   *     Enquiries stack
   * @param registerJobName Name that uniquely identifies register job. Obtained from POSTing to
   *     /register-csv-from-s3/jobs
   * @return Status of register job identified by register job name.
   */
  @ApiOperation(
      value = "Gets status of register job identified by name",
      response = StatusOfRegisterCsvFromS3JobQueryResult.class
  )
  @ApiResponses({
      @ApiResponse(code = 500, message = "Internal Server Error / No message available"),
      @ApiResponse(code = 400, message = "Correlation Id missing"),
      @ApiResponse(code = 404, message = "Register job not found"),
      @ApiResponse(code = 422, message = "Incorrect format of register job name"),
      @ApiResponse(code = 200, message =
          "Status of register job identified by register job name"),
  })
  @ApiImplicitParams({
      @ApiImplicitParam(name = Constants.X_CORRELATION_ID_HEADER,
          required = true,
          value = "CorrelationID to track the request from the API gateway through"
              + " the Enquiries stack",
          paramType = "header"),
      @ApiImplicitParam(name = "registerJobName",
          required = true,
          value = "Name that uniquely identifies register job which status should be returned",
          paramType = "path")
  })
  @GetMapping(
      path = "/{registerJobName}",
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ResponseStatus(value = HttpStatus.OK)
  ResponseEntity<StatusOfRegisterCsvFromS3JobQueryResult> queryForStatusOfRegisterJob(
      @RequestHeader(Constants.X_CORRELATION_ID_HEADER) String correlationId,
      @PathVariable(name = "registerJobName") String registerJobName);
}
