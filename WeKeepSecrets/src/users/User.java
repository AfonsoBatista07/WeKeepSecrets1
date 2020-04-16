package users;

import documents.Document;
import securitySystem.IteratorDocs;

/**
 * @author Jo
 *
 */
public interface User {
	
	
	/**Adiciona o Documento doc a lista de documentos do User
	 * @param doc - Documento
	 */
	void upload(Document doc);
	
	
	/**
	 * @return Id do User
	 */
	String getId();
	
	/**
	 * @return Level do user
	 */
	String getLevel();
	
	/**
	 * @return Tipo de User (Clerk ou Officier)
	 */
	String getKind();
	
	/**Verifica se o Documento com o nome dado ja existe na lista de Documentos do User
	 * @param docName - Nome do Documento
	 * @return True se existe, False se nao existe
	 */
	boolean docExist(String docName);
	
	/**Devolve um Iterador com a lista de documentos do tipo <type> do User
	 * @param type - Tipo de Documento ( Classified ou Official)
	 * @return Iterador
	 */
	IteratorDocs getIteratorDocs(String type);
	
	/**
	 * @return Numero de documentos na lista de documentos do User
	 */
	int getNumDocs();
}
