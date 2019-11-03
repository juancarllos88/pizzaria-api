package br.com.pizzaria.core.api.infrastructure.service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.jxpath.util.TypeUtils;
//import org.apache.commons.lang.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.pizzaria.core.api.application.configuration.ApplicationProperty;
import br.com.pizzaria.core.api.infrastructure.log.LogBuilder;

@Service
public class ParametroServiceImpl {
/*
    private static final Logger log = LoggerFactory.getLogger(ParametroServiceImpl.class);

    @Autowired
    private ParametroClient parametroClient;

    @Autowired
    private ApplicationProperty appProperty;

    @Autowired
    private JwtUserDetailsServiceImpl jwtService;

    @Autowired
    private Environment environment;

    public List<ParametroRequestTO> buscarParametros() throws ClientException {
        jwtService.setUsuario(appProperty.getSeguranca().getUsuarioSistemaToken());
        return parametroClient.buscarParametros().getData();
    }

    public <T> T atribuir(T bean) {
        try {
            if (verificarProfileTestAtivo())
                return bean;
            bean = parse(bean, buscarParametros());
            log.info(LogBuilder.of()
                    .header("Parametrização")
                    .row("Mensagem", "Parâmetros atualizados com sucesso!")
                    .row("Parâmetros", bean)
                    .build());
            return bean;
        } catch (Exception exception) {
            try {
                log.warn(LogBuilder.of()
                    .header("Conversão de Parâmetro")
                    .row("Mensagem", "Não foi possível comunicação com o serviço de parâmetro, por favor, inicialize-o")
                    .build());
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException interruptedException) {
                log.warn(LogBuilder.of()
                    .header("Conversão de Parâmetro")
                    .row("Mensagem", interruptedException.getMessage())
                    .build());
            }
            return atribuir(bean);
        }
    }

    public <T> T parse(T bean, List<ParametroRequestTO> parametros) {
        parametros.forEach(p -> {
            try {
                Field field = bean.getClass().getDeclaredField(p.getChave());
                Object value = p.getRespostas().size() == 1 ? p.getRespostas().get(0) : p.getRespostas();
                FieldUtils.writeDeclaredField(bean, field.getName(), TypeUtils.convert(value, field.getType()), true);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                log.warn(LogBuilder.of()
                    .header("Conversão de Parâmetro")
                    .row("Campo", p.getChave())
                    .row("Mensagem", "Não foi possível converter este campo")
                    .build());
            }
        });
        return bean;
    }

    public boolean verificarProfileTestAtivo() {
        return Arrays.asList(environment.getActiveProfiles()).contains("test");
    }
*/
}
