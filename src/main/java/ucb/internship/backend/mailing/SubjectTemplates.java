package ucb.internship.backend.mailing;

import java.util.Hashtable;

public class SubjectTemplates extends Hashtable<Template, String> {

    public SubjectTemplates ()
    {
        this.put(Template.BASIC, "Internship by Cato - Correo por defecto");
        this.put(Template.VERIFICATION_CODE, "Internship by Cato - Código de verificación");
    }
}
