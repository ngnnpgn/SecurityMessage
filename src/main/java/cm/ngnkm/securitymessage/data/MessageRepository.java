package cm.ngnkm.securitymessage.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

/**
 * Manages {@link Message} instances
 *
 * @author ngnkm
 *
 */

public interface MessageRepository extends CrudRepository<Message, Long> {
	
	  @Query("select m from Message m where m.to.id = ?#{principal?.id}")  //vérifie si l'authentification.getPrincipal ().GetId () est égal au destinataire du message. Notez que cet exemple suppose que vous avez personnalisé le principal pour être un objet doté d'une propriété d'identification. En exposant le bean SecurityEvaluationContextExtension, toutes les expressions de sécurité communes sont disponibles dans la requête.
	   Iterable<Message> findAllToCurrentUser();
	  
	  /**
	   * La sécurité de printemps fournit une sécurité de niveau de méthode à l'aide de @PreAuthorize et @PostAuthorize. Il s'agit d'un contrôle d'accès basé sur l'expression. @PreAuthorize peut vérifier l'autorisation avant d'entrer dans la méthode. @PreAuthorize est vérifié sur la base du rôle ou de l'argument qui est transmis à la méthode. @PostAuthorize vérifie l'authentification après l'exécution de la méthode. @PostAuthorize peut être autorisé sur la base de rôles enregistrés, renvoie l'objet par méthode et l'argument passé à la méthode. Pour la sécurité de ressort de l'objet renvoyé, il fournit un mot-clé intégré, c'est-à-dire returnObject. Définissez @PreAuthorize et @PostAuthorize dans l'interface de la couche de service.
	   **/
	  @PostAuthorize("hasPermission(returnObject,'read')")
	    Message findOne(Long id);
}
