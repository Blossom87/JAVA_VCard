package fr.afpa;

public class VCardSerializer {
    
    /**
     * Méthode de sérialisation vCard d'un objet de la classe "Contact"
     * @param contact
     */
    public void serialize(Contact contact) {

        /// 1 construire la chaîne de caractères correspondant au contenu vCard
        String vCardContent = "BEGIN:VCARD\nVERSION:4.0";

        // Construction du nom
        vCardContent = vCardContent + "N:" + contact.getLastName() + ";" + contact.getFirstName() + ";" + "\n";

        vCardContent = vCardContent + "G";
        // Construction du "full name"
        vCardContent = vCardContent + "FN:" + contact.getFirstName() + " " + contact.getLastName() + "\n";

        vCardContent = vCardContent + "ADR:" + contact.getAddress() + "\n";

        vCardContent = vCardContent; 

        // 2 écrire cette chaîne dans un fichier


    }

}
