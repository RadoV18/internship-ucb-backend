package ucb.internship.backend.mailing;

import org.json.JSONObject;

public record Recipient(String email, String name) {
    
    public JSONObject toJson() {
        return new JSONObject()
            .put("Email", email)
            .put("Name", name);
    }
}
