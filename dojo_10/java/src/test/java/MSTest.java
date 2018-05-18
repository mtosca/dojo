import harnesses.ResourceLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MSTest {
    public static final String MLB_AND_PROMPT_FALSE_MOCK = "{\n" +
            "    \"is_step_required\": {\n" +
            "            \"type\": \"eq\",\n" +
            "            \"expressions\": [\n" +
            "                {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"value\": \"1\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"value\": \"0\"\n" +
            "                }\n" +
            "            ]\n" +
            "    },\n" +
            "    \"billing_info\": [\n" +
            "        {\n" +
            "        \"data\": {\n" +
            "          \"name\": \"Juan\",\n" +
            "          \"last_name\": \"Ucciani\",\n" +
            "          \"doc_type\": \"CPF\",\n" +
            "          \"doc_number\": \"15635614680\",\n" +
            "          \"street_name\": \"Arias\",\n" +
            "          \"street_number\": \"1234\",\n" +
            "          \"additional_info\": null,\n" +
            "          \"zip_code\": \"13478060\",\n" +
            "          \"city\": \"Americana\",\n" +
            "          \"state\": \"Sao Paulo\"\n" +
            "        },\n" +
            "        \"title_formatter\": {\n" +
            "          \"texts\": [\n" +
            "            {\n" +
            "              \"type\": \"text_with_keys\",\n" +
            "              \"value\": \"${name} ${last_name}\",\n" +
            "              \"keys\": [\n" +
            "                \"name\",\n" +
            "                \"last_name\"\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        \"subtitle_formatter\": {\n" +
            "          \"texts\": [\n" +
            "            {\n" +
            "              \"type\": \"text_with_keys\",\n" +
            "              \"value\": \"CPF: ${doc_number}\",\n" +
            "              \"keys\": [\n" +
            "                \"doc_number\"\n" +
            "              ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"type\": \"text\",\n" +
            "              \"value\": \"\\n\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"type\": \"text_with_keys\",\n" +
            "              \"value\": \"${street_name} ${street_number}\",\n" +
            "              \"keys\": [\n" +
            "                \"street_name\", \"street_number\"\n" +
            "              ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"type\": \"text\",\n" +
            "              \"value\": \"\\n\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"type\": \"text_with_keys\",\n" +
            "              \"value\": \"${city}, ${state} - CEP ${zip_code}\",\n" +
            "              \"keys\": [\n" +
            "                \"city\", \"state\", \"zip_code\"\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      }\n" +
            "    ],\n" +
            "    \"form\": {\n" +
            "        \n" +
            "    }\n" +
            "}";

    public static final String MLA_AND_PROMPT_TRUE_MOCK = "{\n" +
            "  \"billing_info\": [\n" +
            "    {\n" +
            "      \"data\": {\n" +
            "        \"additional_info\": null,\n" +
            "        \"city\": \"Saavedra\",\n" +
            "        \"doc_number\": \"54433423\",\n" +
            "        \"doc_type\": \"DNI\",\n" +
            "        \"last_name\": \"Ucciani\",\n" +
            "        \"name\": \"Juan\",\n" +
            "        \"state\": \"C.A.B.A.\",\n" +
            "        \"street_name\": \"Arias\",\n" +
            "        \"street_number\": \"1234\",\n" +
            "        \"zip_code\": \"1430\"\n" +
            "      },\n" +
            "      \"subtitle_formatter\": {\n" +
            "        \"texts\": [\n" +
            "          {\n" +
            "            \"keys\": [\n" +
            "              \"doc_number\"\n" +
            "            ],\n" +
            "            \"type\": \"text_with_keys\",\n" +
            "            \"value\": \"DNI: ${doc_number}\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"text\",\n" +
            "            \"value\": \"\\n\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"keys\": [\n" +
            "              \"street_name\",\n" +
            "              \"street_number\"\n" +
            "            ],\n" +
            "            \"type\": \"text_with_keys\",\n" +
            "            \"value\": \"${street_name} ${street_number}\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"text\",\n" +
            "            \"value\": \"\\n\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"keys\": [\n" +
            "              \"city\",\n" +
            "              \"state\",\n" +
            "              \"zip_code\"\n" +
            "            ],\n" +
            "            \"type\": \"text_with_keys\",\n" +
            "            \"value\": \"${city}, ${state} - CP ${zip_code}\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"title_formatter\": {\n" +
            "        \"texts\": [\n" +
            "          {\n" +
            "            \"keys\": [\n" +
            "              \"name\",\n" +
            "              \"last_name\"\n" +
            "            ],\n" +
            "            \"type\": \"text_with_keys\",\n" +
            "            \"value\": \"${name} ${last_name}\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"form\": {\n" +
            "    \"sections\": [\n" +
            "      {\n" +
            "        \"action\": {\n" +
            "          \"data\": {\n" +
            "            \"next_step\": \"juridica\",\n" +
            "            \"title\": \"Soy una empresa\",\n" +
            "            \"value\": \"changeForm\"\n" +
            "          },\n" +
            "          \"type\": \"link\"\n" +
            "        },\n" +
            "        \"id\": \"user_section\",\n" +
            "        \"inputs\": [\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"data-mask\",\n" +
            "                  \"value\": \"3.3.3-2\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 8\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 6\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Este dato es inválido\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^(\\\\d{0,2}).?(\\\\d{3}).?(\\\\d{3})$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"input_group\": \"document\",\n" +
            "              \"title\": \"DNI\",\n" +
            "              \"value\": \"33444555\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"docNumber\",\n" +
            "            \"output\": \"number\",\n" +
            "            \"type\": \"number\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Este dato es inválido\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^((FORCEERROR_\\\\d{4})|[A-Za-zÀ-Ÿà-ÿ ,.']+)$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Nombre\",\n" +
            "              \"value\": \"Juan\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"firstName\",\n" +
            "            \"output\": \"first_name\",\n" +
            "            \"type\": \"text\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Este dato es inválido\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^((FORCEERROR_\\\\d{4})|[A-Za-zÀ-Ÿà-ÿ ,.']+)$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Apellido\",\n" +
            "              \"value\": \"Ucciani\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"lastName\",\n" +
            "            \"output\": \"last_name\",\n" +
            "            \"type\": \"text\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"subtitle\": \"Ingresalos correctamente para que se genere tu boleto.\",\n" +
            "        \"title\": \"Mis datos personales\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"address_section\",\n" +
            "        \"inputs\": [\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"autoComplete\",\n" +
            "                  \"value\": \"shipping street-address\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 70\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"No incluya caracteres especiales como > < = ;\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^[^_\\\\?¿;¡¨·\\\\+`´\\\\[\\\\]\\\\*\\\\=\\\\\\\"\\\\<\\\\>\\\\{\\\\}\\\\$\\\\%\\\\^\\\\!\\\\@\\\\u2000-\\\\uFFFF]*$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Calle\",\n" +
            "              \"value\": \"Arias\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"street\",\n" +
            "            \"output\": \"street_name\",\n" +
            "            \"type\": \"text\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attachments\": [\n" +
            "                {\n" +
            "                  \"data\": {\n" +
            "                    \"match_behaviour\": \"makeFieldOptional\",\n" +
            "                    \"optional_value\": \"SN\",\n" +
            "                    \"title\": \"Sin número\"\n" +
            "                  },\n" +
            "                  \"type\": \"checkbox\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"autoComplete\",\n" +
            "                  \"value\": \"shipping street-address\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 7\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Verifica este dato\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^SN$|^[1-9][0-9]*[a-zA-Z]*$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Número\",\n" +
            "              \"value\": \"1234\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"streetNumber\",\n" +
            "            \"output\": \"street_number\",\n" +
            "            \"type\": \"number\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 70\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"No incluya caracteres especiales como > < = ;\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^[^_\\\\?¿;¡¨·\\\\+`´\\\\[\\\\]\\\\*\\\\=\\\\\\\"\\\\<\\\\>\\\\{\\\\}\\\\$\\\\%\\\\^\\\\!\\\\@\\\\u2000-\\\\uFFFF]*$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"optional_text\": \"(opcional)\",\n" +
            "              \"title\": \"Piso / Departamento\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"additionalInfo\",\n" +
            "            \"output\": \"additional_info\",\n" +
            "            \"type\": \"text\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attachments\": [\n" +
            "                {\n" +
            "                  \"data\": {\n" +
            "                    \"title\": \"No se mi código\",\n" +
            "                    \"value\": \"http://www.buscacep.correios.com.br/sistemas/buscacep/\"\n" +
            "                  },\n" +
            "                  \"type\": \"link\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"autoComplete\",\n" +
            "                  \"value\": \"shipping postal-code\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"readOnly\",\n" +
            "                  \"value\": \"false\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"data-mask\",\n" +
            "                  \"value\": \"4\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 4\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 4\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Este dato es inválido\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^\\\\d{4}$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Código postal\",\n" +
            "              \"value\": \"1430\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"zipCode\",\n" +
            "            \"output\": \"zip_code\",\n" +
            "            \"type\": \"number\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 70\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"No incluya caracteres especiales como > < = ;\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^[^_\\\\?¿;¡¨·\\\\+`´\\\\[\\\\]\\\\*\\\\=\\\\\\\"\\\\<\\\\>\\\\{\\\\}\\\\$\\\\%\\\\^\\\\!\\\\@\\\\u2000-\\\\uFFFF]*$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Localidad / Barrio\",\n" +
            "              \"value\": \"Americana\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"city\",\n" +
            "            \"output\": \"city\",\n" +
            "            \"type\": \"text\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                }\n" +
            "              ],\n" +
            "              \"options\": [\n" +
            "                {\n" +
            "                  \"label\": \"Cordoba\",\n" +
            "                  \"value\": \"Cordoba\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Buenos Aires\",\n" +
            "                  \"value\": \"Buenos Aires\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Provincia\",\n" +
            "              \"value\": \"Cordoba\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"state\",\n" +
            "            \"output\": \"state\",\n" +
            "            \"type\": \"select\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"title\": \"Domicilio de facturacion\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"is_step_required\": {\n" +
            "    \"expressions\": [\n" +
            "      {\n" +
            "        \"type\": \"string\",\n" +
            "        \"value\": \"1\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"type\": \"string\",\n" +
            "        \"value\": \"1\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"type\": \"eq\"\n" +
            "  }\n" +
            "}";

    public static final String MLB_AND_PROMPT_TRUE_MOCK = "{\n" +
            "  \"billing_info\": [],\n" +
            "  \"form\": {\n" +
            "    \"sections\": [\n" +
            "      {\n" +
            "        \"action\": {\n" +
            "          \"data\": {\n" +
            "            \"next_step\": \"fisica\",\n" +
            "            \"title\": \"Sou uma pessoa\",\n" +
            "            \"value\": \"changeForm\"\n" +
            "          },\n" +
            "          \"type\": \"link\"\n" +
            "        },\n" +
            "        \"id\": \"user_section\",\n" +
            "        \"inputs\": [\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa esse dado\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Esse dato e inválido\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^((FORCEERROR_\\\\d{4})|[A-Za-zÀ-Ÿà-ÿ ,.']+)$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Razão social\",\n" +
            "              \"value\": \"\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"firstName\",\n" +
            "            \"output\": \"first_name\",\n" +
            "            \"type\": \"text\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"data-mask\",\n" +
            "                  \"value\": \"2-8-1\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa esse dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 14\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 14\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Este dato es inválido\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^(\\\\d{2}).?(\\\\d{3}).?(\\\\d{3})/?(\\\\d{4})-?(\\\\d{2})$\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"El CNPJ es inválido\",\n" +
            "                  \"name\": \"documentValidation\",\n" +
            "                  \"value\": \"CNPJ-MLB\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"input_group\": \"document\",\n" +
            "              \"title\": \"CNPJ\",\n" +
            "              \"value\": \"\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"docNumber\",\n" +
            "            \"output\": \"number\",\n" +
            "            \"type\": \"number\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"alters\": {\n" +
            "                \"inscripcionEstadual\": [\n" +
            "                  {\n" +
            "                    \"aspect_id\": \"requiredField\",\n" +
            "                    \"rule\": {\n" +
            "                      \"expressions\": [\n" +
            "                        {\n" +
            "                          \"type\": \"string\",\n" +
            "                          \"value\": \"Contribuinte\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                          \"type\": \"input_value\",\n" +
            "                          \"value\": \"this\"\n" +
            "                        }\n" +
            "                      ],\n" +
            "                      \"type\": \"eq\"\n" +
            "                    }\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"aspect_id\": \"disabledField\",\n" +
            "                    \"rule\": {\n" +
            "                      \"expressions\": [\n" +
            "                        {\n" +
            "                          \"type\": \"string\",\n" +
            "                          \"value\": \"Não Contribuinte\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                          \"type\": \"input_value\",\n" +
            "                          \"value\": \"this\"\n" +
            "                        }\n" +
            "                      ],\n" +
            "                      \"type\": \"eq\"\n" +
            "                    }\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa esse dado\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                }\n" +
            "              ],\n" +
            "              \"options\": [\n" +
            "                {\n" +
            "                  \"label\": \"Contribuinte\",\n" +
            "                  \"value\": \"Contribuinte\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Não Contribuinte\",\n" +
            "                  \"value\": \"Não Contribuinte\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Tipo do contribuinte\",\n" +
            "              \"value\": \"Contribuinte\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"contribuyente\",\n" +
            "            \"output\": \"contribuyente\",\n" +
            "            \"type\": \"select\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"aspects\": {\n" +
            "                \"BR-AC\": {\n" +
            "                  \"constraints\": [\n" +
            "                    {\n" +
            "                      \"error_message\": \"El dato es inválido\",\n" +
            "                      \"name\": \"inscriptionValidation\",\n" +
            "                      \"value\": \"BR-AC\"\n" +
            "                    }\n" +
            "                  ]\n" +
            "                },\n" +
            "                \"BR-SP\": {\n" +
            "                  \"constraints\": [\n" +
            "                    {\n" +
            "                      \"error_message\": \"El dato es inválido\",\n" +
            "                      \"name\": \"inscriptionValidation\",\n" +
            "                      \"value\": \"BR-SP\"\n" +
            "                    }\n" +
            "                  ]\n" +
            "                },\n" +
            "                \"disabledField\": {\n" +
            "                  \"attributes\": [\n" +
            "                    {\n" +
            "                      \"name\": \"readOnly\",\n" +
            "                      \"value\": \"true\"\n" +
            "                    }\n" +
            "                  ],\n" +
            "                  \"constraints\": [\n" +
            "                    {\n" +
            "                      \"error_message\": \"Completa este dato\",\n" +
            "                      \"name\": \"required\",\n" +
            "                      \"value\": false\n" +
            "                    }\n" +
            "                  ]\n" +
            "                },\n" +
            "                \"requiredField\": {\n" +
            "                  \"attributes\": [\n" +
            "                    {\n" +
            "                      \"name\": \"readOnly\",\n" +
            "                      \"value\": \"false\"\n" +
            "                    }\n" +
            "                  ],\n" +
            "                  \"constraints\": [\n" +
            "                    {\n" +
            "                      \"error_message\": \"Completa este dato\",\n" +
            "                      \"name\": \"required\",\n" +
            "                      \"value\": true\n" +
            "                    }\n" +
            "                  ]\n" +
            "                }\n" +
            "              },\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"data-mask\",\n" +
            "                  \"value\": \"2-8-1\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 16\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 6\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Este dato es inválido\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^(\\\\d{6,16})$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"input_group\": \"document\",\n" +
            "              \"title\": \"Inscrição estadual\",\n" +
            "              \"value\": \"\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"inscripcionEstadual\",\n" +
            "            \"output\": \"inscripcion_estadual\",\n" +
            "            \"type\": \"number\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"title\": \"Dados da empresa\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"address_section\",\n" +
            "        \"inputs\": [\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attachments\": [\n" +
            "                {\n" +
            "                  \"data\": {\n" +
            "                    \"title\": \"No se mi cep\",\n" +
            "                    \"value\": \"http://www.buscacep.correios.com.br/sistemas/buscacep/\"\n" +
            "                  },\n" +
            "                  \"type\": \"link\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"autoComplete\",\n" +
            "                  \"value\": \"shipping postal-code\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"readOnly\",\n" +
            "                  \"value\": \"false\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"data-mask\",\n" +
            "                  \"value\": \"4\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 8\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 8\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Este dato es inválido\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^\\\\d{5}-?\\\\d{3}$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"CEP\",\n" +
            "              \"value\": \"\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"zipCode\",\n" +
            "            \"output\": \"zip_code\",\n" +
            "            \"type\": \"number\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"autoComplete\",\n" +
            "                  \"value\": \"shipping street-address\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 70\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"No incluya caracteres especiales como > < = ;\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^[^_\\\\?¿;¡¨·\\\\+`´\\\\[\\\\]\\\\*\\\\=\\\\\\\"\\\\<\\\\>\\\\{\\\\}\\\\$\\\\%\\\\^\\\\!\\\\@\\\\u2000-\\\\uFFFF]*$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Rua / Avenida\",\n" +
            "              \"value\": \"\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"street\",\n" +
            "            \"output\": \"street_name\",\n" +
            "            \"type\": \"text\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attachments\": [\n" +
            "                {\n" +
            "                  \"data\": {\n" +
            "                    \"match_behaviour\": \"makeFieldOptional\",\n" +
            "                    \"optional_value\": \"SN\",\n" +
            "                    \"title\": \"Sin número\"\n" +
            "                  },\n" +
            "                  \"type\": \"checkbox\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"autoComplete\",\n" +
            "                  \"value\": \"shipping street-address\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 7\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"Verifica este dato\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^SN$|^[1-9][0-9]*[a-zA-Z]*$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Numero\",\n" +
            "              \"value\": \"\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"streetNumber\",\n" +
            "            \"output\": \"street_number\",\n" +
            "            \"type\": \"number\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 70\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"No incluya caracteres especiales como > < = ;\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^[^_\\\\?¿;¡¨·\\\\+`´\\\\[\\\\]\\\\*\\\\=\\\\\\\"\\\\<\\\\>\\\\{\\\\}\\\\$\\\\%\\\\^\\\\!\\\\@\\\\u2000-\\\\uFFFF]*$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"optional_text\": \"(opcional)\",\n" +
            "              \"title\": \"\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"additionalInfo\",\n" +
            "            \"output\": \"additional_info\",\n" +
            "            \"type\": \"text\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"maxLength\",\n" +
            "                  \"value\": 70\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"La cantidad de caracteres es inválida\",\n" +
            "                  \"name\": \"minLength\",\n" +
            "                  \"value\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                  \"error_message\": \"No incluya caracteres especiales como > < = ;\",\n" +
            "                  \"name\": \"pattern\",\n" +
            "                  \"value\": \"^[^_\\\\?¿;¡¨·\\\\+`´\\\\[\\\\]\\\\*\\\\=\\\\\\\"\\\\<\\\\>\\\\{\\\\}\\\\$\\\\%\\\\^\\\\!\\\\@\\\\u2000-\\\\uFFFF]*$\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Cidade\",\n" +
            "              \"value\": \"\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"city\",\n" +
            "            \"output\": \"city\",\n" +
            "            \"type\": \"text\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"data\": {\n" +
            "              \"alters\": {\n" +
            "                \"inscripcionEstadual\": [\n" +
            "                  {\n" +
            "                    \"aspect_id\": \"BR-AC\",\n" +
            "                    \"rule\": {\n" +
            "                      \"expressions\": [\n" +
            "                        {\n" +
            "                          \"type\": \"string\",\n" +
            "                          \"value\": \"Acre\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                          \"type\": \"input_value\",\n" +
            "                          \"value\": \"this\"\n" +
            "                        }\n" +
            "                      ],\n" +
            "                      \"type\": \"eq\"\n" +
            "                    }\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"aspect_id\": \"BR-SP\",\n" +
            "                    \"rule\": {\n" +
            "                      \"expressions\": [\n" +
            "                        {\n" +
            "                          \"type\": \"string\",\n" +
            "                          \"value\": \"São Paulo\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                          \"type\": \"input_value\",\n" +
            "                          \"value\": \"this\"\n" +
            "                        }\n" +
            "                      ],\n" +
            "                      \"type\": \"eq\"\n" +
            "                    }\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              \"attributes\": [\n" +
            "                {\n" +
            "                  \"name\": \"spellCheck\",\n" +
            "                  \"value\": \"false\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"constraints\": [\n" +
            "                {\n" +
            "                  \"error_message\": \"Completa este dato\",\n" +
            "                  \"name\": \"required\",\n" +
            "                  \"value\": true\n" +
            "                }\n" +
            "              ],\n" +
            "              \"options\": [\n" +
            "                {\n" +
            "                  \"label\": \"Acre\",\n" +
            "                  \"value\": \"Acre\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Alagoas\",\n" +
            "                  \"value\": \"Alagoas\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Amapá\",\n" +
            "                  \"value\": \"Amapá\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Amazonas\",\n" +
            "                  \"value\": \"Amazonas\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Bahia\",\n" +
            "                  \"value\": \"Bahia\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Ceará\",\n" +
            "                  \"value\": \"Ceará\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Distrito Federal\",\n" +
            "                  \"value\": \"Distrito Federal\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Espírito Santo\",\n" +
            "                  \"value\": \"Espírito Santo\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Goiás\",\n" +
            "                  \"value\": \"Goiás\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Maranhão\",\n" +
            "                  \"value\": \"Maranhão\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Mato Grosso\",\n" +
            "                  \"value\": \"Mato Grosso\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Mato Grosso do Sul\",\n" +
            "                  \"value\": \"Mato Grosso do Sul\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Minas Gerais\",\n" +
            "                  \"value\": \"Minas Gerais\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Pará\",\n" +
            "                  \"value\": \"Pará\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Paraíba\",\n" +
            "                  \"value\": \"Paraíba\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Paraná\",\n" +
            "                  \"value\": \"Paraná\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Pernambuco\",\n" +
            "                  \"value\": \"Pernambuco\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Piauí\",\n" +
            "                  \"value\": \"Piauí\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Rio de Janeiro\",\n" +
            "                  \"value\": \"Rio de Janeiro\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Rio Grande do Norte\",\n" +
            "                  \"value\": \"Rio Grande do Norte\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Rio Grande do Sul\",\n" +
            "                  \"value\": \"Rio Grande do Sul\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Rondônia\",\n" +
            "                  \"value\": \"Rondônia\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Roraima\",\n" +
            "                  \"value\": \"Roraima\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Santa Catarina\",\n" +
            "                  \"value\": \"Santa Catarina\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"São Paulo\",\n" +
            "                  \"value\": \"São Paulo\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Sergipe\",\n" +
            "                  \"value\": \"Sergipe\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"label\": \"Tocantis\",\n" +
            "                  \"value\": \"Tocantis\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"title\": \"Estado\",\n" +
            "              \"value\": \"Acre\"\n" +
            "            },\n" +
            "            \"error\": null,\n" +
            "            \"id\": \"state\",\n" +
            "            \"output\": \"state\",\n" +
            "            \"type\": \"select\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"title\": \"Endereço de cobrança\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"subtitle_formatter\": {\n" +
            "      \"texts\": [\n" +
            "        {\n" +
            "          \"keys\": [\n" +
            "            \"doc_number\"\n" +
            "          ],\n" +
            "          \"type\": \"text_with_keys\",\n" +
            "          \"value\": \"CPF: ${doc_number}\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"\\n\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"keys\": [\n" +
            "            \"street_name\",\n" +
            "            \"street_number\"\n" +
            "          ],\n" +
            "          \"type\": \"text_with_keys\",\n" +
            "          \"value\": \"${street_name} ${street_number}\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"\\n\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"keys\": [\n" +
            "            \"city\",\n" +
            "            \"state\",\n" +
            "            \"zip_code\"\n" +
            "          ],\n" +
            "          \"type\": \"text_with_keys\",\n" +
            "          \"value\": \"${city}, ${state} - CEP ${zip_code}\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"title_formatter\": {\n" +
            "      \"texts\": [\n" +
            "        {\n" +
            "          \"keys\": [\n" +
            "            \"name\",\n" +
            "            \"last_name\"\n" +
            "          ],\n" +
            "          \"type\": \"text_with_keys\",\n" +
            "          \"value\": \"${name} ${last_name}\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"is_step_required\": {\n" +
            "      \"expressions\": [\n" +
            "        {\n" +
            "          \"type\": \"string\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"string\",\n" +
            "          \"value\": \"1\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"type\": \"eq\"\n" +
            "  }\n" +
            "}";

    @Test
    public void test_congrats_order_paid_off_for_android_7_12_0() throws IOException {
        assertEquals("", MLB_AND_PROMPT_TRUE_MOCK);

    }
}
