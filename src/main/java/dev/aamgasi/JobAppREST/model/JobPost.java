package dev.aamgasi.JobAppREST.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Document(collection = "JobPost")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {

    @Id
    private String id = ObjectId.get().toHexString();
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
}
