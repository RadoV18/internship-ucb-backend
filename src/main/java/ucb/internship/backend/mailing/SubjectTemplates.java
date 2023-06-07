package ucb.internship.backend.mailing;

import java.util.Hashtable;

public class SubjectTemplates extends Hashtable<Template, String> {

    public SubjectTemplates () {
        this.put(Template.BASIC, "Internship by Cato - Correo por defecto");
        this.put(Template.VERIFICATION_CODE, "Internship by Cato - Código de verificación");
        this.put(Template.SIGN_UP_REQUEST_STATUS, "Internship by Cato - Estado de solicitud de registro");
        this.put(Template.INTERNSHIP_APPLICATION_UPDATE, "Internship by Cato - Actualización de solicitud de pasantía");
    }
}
