package DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Data
public class DTORandomUser {
    private List<Result> results;

    private Info info;

    @Getter
    @Setter

    public class Result {

        private String gender;
        private Name name;
        private Location location;
        private String email;
        private Login login;
        private Dob dob;
        private Registered registered;
        private String phone;
        private String cell;
        private Id id;
        private Picture picture;
        private String nat;
    }

    @Getter
    @Setter
    public class Name {

        private String title;
        private String first;
        private String last;
    }

    @Getter
    @Setter
    @Builder
    public class Location {

        private String street;
        private String city;
        private String state;
        private String postcode;
        private Coordinates coordinates;
        private Timezone timezone;
    }

    @Getter
    @Setter
    public class Login {

        private String uuid;
        private String username;
        private String password;
        private String salt;
        private String md5;
        private String sha1;
        private String sha256;
    }

    @Getter
    @Setter
    public class Dob {

        private String date;
        private Integer age;
    }

    @Getter
    @Setter
    public class Registered {

        private String date;
        private Integer age;
    }

    @Getter
    @Setter
    public class Id {

        private String name;
        private String value;
    }

    @Getter
    @Setter
    public class Picture {

        private String large;
        private String medium;
        private String thumbnail;
    }

    @Getter
    @Setter
    public class Timezone {

        private String offset;
        private String description;
    }

    @Getter
    @Setter
    public class Info {

        private String seed;
        private Integer results;
        private Integer page;
        private String version;
    }

    @Getter
    @Setter
    public class Coordinates {

        private String latitude;
        private String longitude;
    }
}
