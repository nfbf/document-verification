# Document-verification
API que verifica e valida dados binários na base64

# Rotas Disponíveis
As rotas disponíveis são mostradas abaixo, assim como os parâmetros necessários.

POST: Rotas reponsáveis por enviar o(s) dado(s) informado(s)

http://localhost:8080/v1/diff/{id}/right 

http://localhost:8080/v1/diff/{id}/left

Deve ser enviado o dado através do body. Deve-se utilizar o body a seguir como base:

{

 "dataJson":"QUJDRQ=="

}

GET: Essa rota posibilita a consulta dos dados do documento retornando uma mensagem.

http://localhost:8080/v1/diff/{id}

O retorno segue os seguintes requisitos:

Se	os	documentos	forem	igual,	retorne	“Documentos	<id> idênticos".

Se	os	documentos	não	forem	do	mesmo	tamanho,	retorne	“Documentos	<ID> com	tamanhos	diferentes".

Se	os	documentos	forem	do	mesmo	tamanho	não	é necessário um	diff real,	somente retornar	em	qual	posição	(Offset) os	documentos se	diferem.
