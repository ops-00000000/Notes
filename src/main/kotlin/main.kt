fun main(){
    val note= Note(1,1,"..","...",".....",0)
    val service = NoteService()
    service.addNote(note)
   service.getNotes()

}
