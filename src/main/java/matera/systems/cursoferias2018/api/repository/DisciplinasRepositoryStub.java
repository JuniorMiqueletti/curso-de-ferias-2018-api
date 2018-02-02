package matera.systems.cursoferias2018.api.repository;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("stub")
public class DisciplinasRepositoryStub implements DisciplinaRepository {

    public static final UUID DISCIPLINA_1 = UUID.fromString("e7e62e99-ab62-4e29-9133-b72c3ec6689e");
    public static final UUID DISCIPLINA_2 = UUID.fromString("c7e7c717-077b-415f-a20e-e2b5ebbb3cc2");
    public static final UUID DISCIPLINA_3 = UUID.fromString("1636764a-ec60-447b-b9d5-792546bc87b0");

    private static final Map<UUID, DisciplinaEntity> data = new HashMap<>();

    @Autowired
    private UsuarioService service;

    static {
        {
        	UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setUuid(UsuarioRepositoryStub.USUARIO_1);
            usuarioEntity.setEmail("usuario_1@domain.com");
            usuarioEntity.setLogin("usuario_1");
            usuarioEntity.setNome("Usuario Um");
            usuarioEntity.setPerfil("USUARIO");
            usuarioEntity.setSenha("senha");
            usuarioEntity.setUrlPhoto("http://bucket/usuario/1/perfil.png");
            
            DisciplinaEntity entity = new DisciplinaEntity();
            entity.setId(DISCIPLINA_1);
            entity.setDataInicio("22/01/2018");
            entity.setDataTermino("03/02/2018");
            entity.setDescricao("java REST");
            entity.setSegmento("BACKEND");
            entity.setUsuarios(Arrays.asList(usuarioEntity));

            data.put(DISCIPLINA_1, entity);
        }

        {
            DisciplinaEntity entity = new DisciplinaEntity();
            entity.setId(DISCIPLINA_2);
            entity.setDataInicio("22/01/2018");
            entity.setDataTermino("03/02/2018");
            entity.setDescricao("Angular");
            entity.setSegmento("FRONTEND");
            entity.setUsuarios(new ArrayList<>());
 
            data.put(DISCIPLINA_2, entity);
        }

        {
            DisciplinaEntity entity = new DisciplinaEntity();
            entity.setId(DISCIPLINA_3);
            entity.setDataInicio("22/01/2018");
            entity.setDataTermino("03/02/2018");
            entity.setDescricao("Ionic");
            entity.setSegmento("MOBILE");
            entity.setUsuarios(new ArrayList<>());
            
            data.put(DISCIPLINA_3, entity);
        }
    }

    @Override
    public UUID criar(DisciplinaEntity disciplina) {
        UUID uuid = UUID.randomUUID();
        data.put(uuid, disciplina);
        return uuid;
    }

    @Override
    public void deletar(UUID uuid) {
        data.remove(uuid);
    }

    @Override
    public List<DisciplinaEntity> listar() {
        return new ArrayList<DisciplinaEntity>(data.values());
    }

    @Override
    public Optional<DisciplinaEntity> findByID(UUID uuid) {
        return Optional.ofNullable(data.getOrDefault(uuid, null));
    }

    @Override
    public void atualizar(DisciplinaEntity update) {
        data.put(update.getId(), update);
    }

    @Override
    public List<UsuarioResponse> findUsuariosByDisciplinaID(UUID idDisciplina) {
        return service.getUsuarios();
    }
}
