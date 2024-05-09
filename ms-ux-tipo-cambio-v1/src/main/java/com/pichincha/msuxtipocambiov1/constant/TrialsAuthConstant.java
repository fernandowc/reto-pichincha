package com.pichincha.msuxtipocambiov1.constant;

import org.springframework.stereotype.Component;

@Component
public class TrialsAuthConstant {

    private TrialsAuthConstant() {

    }

    public static final String URI_POST_GOREST_AUTH = "/public/v2/users";
    public static final String URI_POST_API_SUPPORT_SOLICITUD = "/api/v1/sp/solicitud";
    public static final String URI_POST_API_SUPPORT_TIPO_CAMBIO = "/api/v1/sp/tipocambio";

}
