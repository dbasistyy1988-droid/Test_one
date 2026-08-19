package rest.assertions;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;



public class BasicApiAssert extends AbstractAssert<BasicApiAssert, Response> {

    public BasicApiAssert(Response actual) {
        super(actual, BasicApiAssert.class);
        actual.prettyPrint();

    }

    public static BasicApiAssert assertThat(Response acctual) {
        return new BasicApiAssert(acctual);
    }

    public BasicApiAssert statusCodeIsEquals(int code){
        Assertions.assertThat(actual.statusCode())
                .as("Status code must be %d".formatted(code))
                .isEqualTo(code);

        return  this;
    }

    public BasicApiAssert fieldIsExists(String path){
        Assertions.assertThat(actual. jsonPath().getString(path))
                .as("Field with path %s must be exists!".formatted(path))
                .isNotNull();

        return  this;

    }
    public BasicApiAssert fieldIsEquals(String path, String value){
        Assertions.assertThat(actual. jsonPath().getString(path))
                .as("Field with path %s must be equals '%s'!".formatted(path, value))
                .isEqualToIgnoringCase(value);

        return  this;

    }

    public BasicApiAssert headerIsEqual(String header, String value){
        Assertions.assertThat(actual.getHeader(header))
                .as("Header '%s' must equal '%s'".formatted(header, value))
                .isEqualToIgnoringCase(value);

        return this;
    }

    public BasicApiAssert listSizeIsEqualOrGreater(String path, int size){
        Assertions.assertThat(actual.jsonPath().getList(path, String.class))
                .as("List with pash %s must be size %d or greater".formatted(path, size))
                .hasSizeGreaterThanOrEqualTo(size);

        return this;
    }

}
