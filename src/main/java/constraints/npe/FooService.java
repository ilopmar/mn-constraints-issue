package constraints.npe;

import io.micronaut.context.annotation.DefaultImplementation;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;

@DefaultImplementation(FooServiceImpl.class)
public interface FooService {

    @Nonnull
    String methodWithString(@NotBlank String param);

}
