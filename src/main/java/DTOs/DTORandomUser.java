package DTOs;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement

public class DTORandomUser {
    public List<Result> results;
    public Info info;



    public class Result {

        public String gender;
        public Name name;
        public Location location;
        public String email;
        public Login login;
        public Dob dob;
        public Registered registered;
        public String phone;
        public String cell;
        public Id id;
        public Picture picture;
        public String nat;
    }

    public class Name {

        public String title;
        public String first;
        public String last;
    }

    public class Location {

        public String street;
        public String city;
        public String state;
        public String postcode;
        public Coordinates coordinates;
        public Timezone timezone;
    }

    public class Login {

        public String uuid;
        public String username;
        public String password;
        public String salt;
        public String md5;
        public String sha1;
        public String sha256;
    }

    public class Dob {

        public String date;
        public Integer age;
    }

    public class Registered {

        public String date;
        public Integer age;
    }

    public class Id {

        public String name;
        public Object value;
    }

    public class Picture {

        public String large;
        public String medium;
        public String thumbnail;
    }


    public class Timezone {

        public String offset;
        public String description;
    }

    public class Info {

        public String seed;
        public Integer results;
        public Integer page;
        public String version;
    }

    public class Coordinates {

        public String latitude;
        public String longitude;
    }
}
