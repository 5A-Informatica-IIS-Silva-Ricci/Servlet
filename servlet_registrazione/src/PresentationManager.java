public class PresentationManager {
    public final static String paginaSuccesso = """
            <!DOCTYPE html>
            <html lang="it">
            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Utente registrato</title>
            </head>
            <body>
                <h1>Registrazione avvenuta con successo</h1>
            </body>
            </html>
            """;

    public final static String paginaErrore = """
            <!DOCTYPE html>
            <html lang="it">
            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Errore registrazione</title>
            </head>
            <body>
             <h1>Qualcosa è andato storto nella registrazione</h1>
            </body>
            </html>
            """;
}
