package com.example.BD_RestAPI.service;
import com.example.BD_RestAPI.repository.UserRepository;
import com.example.BD_RestAPI.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> obterTodos() {
        return userRepository.findAll();
    }

    public List<UserEntity> obterNome(String nome){return userRepository.findByNomeIgnoreCase(nome);}
    public List<UserEntity> obterEmail(String email){return userRepository.findByEmailIgnoreCase(email);}
    public List<UserEntity> obterEmailNome(String email, String nome){return userRepository.findByNomeAndEmailAllIgnoreCase(email, nome);}
    public List<UserEntity> obterPrefixo(String prefix){return userRepository.findByNomeStartingWithIgnoreCase(prefix);}
    public List<UserEntity> obterSub(String sub){return userRepository.findByNomeContainingIgnoreCase(sub);}
    public UserEntity obterPorId(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity inserir(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity atualizar(String id, UserEntity newUser) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setNome(newUser.getNome());
            existingUser.setEmail(newUser.getEmail());
            return userRepository.save(existingUser);
        } else {
            // Se o usuário não existe:
            return null;
            // Podemos também lançar uma exceção:
            // throw new EntityNotFoundException("Usuário com id " + id + " não encontrado");
        }
    }

    public void excluir(String id) {
        userRepository.deleteById(id);
    }

    public void inserirLista(List<UserEntity> users)
    {
        for (UserEntity user: users) {
           userRepository.save(user);
        }
    }
    public void  ExcluirTodos()
    {
        var dados = userRepository.findAll();
        for (UserEntity user: dados) {
            userRepository.existsById(user.getId());
        }
    }
    public int BuscarProximoId() {

        List<UserEntity> usuarios = userRepository.findAll();
        int ultimoId = -1;

        for (UserEntity usuario : usuarios) {
            int idAtual = Integer.parseInt(usuario.getId());
            if (idAtual > ultimoId) {
                ultimoId = idAtual;
            }
        }
        return ultimoId + 1;
    }
    //https://github.com/PetronioFaleixo/Arquitetura-Web/blob/main/BD_RestAPI/src/main/java/com/example/RestAPI/service/UserService.java//

}