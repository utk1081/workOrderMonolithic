package de.gloresoft.workorderapi.converters;

import de.gloresoft.workorderapi.entities.User;
import de.gloresoft.workorderapi.entities.security.UserDto;
import de.gloresoft.workorderapi.exceptions.DateNotParsedException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {
    @Override
    @Nullable
    public User convert(UserDto source) {
        if(source == null) {
            return null;
        }
        final User user = new User();
        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());
        String dob = source.getDateOfBirth();
        try {
            String[] dateElements = dob.split("-");
            int month = Integer.parseInt(dateElements[0]);
            int day = Integer.parseInt(dateElements[1]);
            int year = Integer.parseInt(dateElements[2]);
            LocalDate dateOfBirth = LocalDate.of(year, Month.of(month), day);
            user.setDateOfBirth(dateOfBirth);
        } catch (NumberFormatException | DateTimeException e) {
            throw new DateNotParsedException(dob+ " is not a correctly formatted date. ", e);
        }
        //user.setRole(source.getRole());
        return user;
    }
}
