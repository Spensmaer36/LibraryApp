<#import "../layout.ftlh" as main>
<@main.layout>
    <div class="container text-center">
        <div class="row">
            <div class="center mt-3 mb-3">
                <a type="button" class="btn btn-primary" style="padding: 10px 50px" href="book/create">Add new book</a>
            </div>
            <#list books as book>
                <div class="col m-2">
                    <div class="card" style="width: 18rem; min-height: 200px">
                        <div class="card-header">
                            <h5 class="card-title">${book.title}</h5>
                        </div>
                        <div class="card-body">
                            <p class="card-text"> ${book.description}</p>
                            <p class="card-text">Author: ${author.getAuthorById(book.authorId).name}</p>
                            <p class="card-text">Release Date: ${book.releaseDate}</p>
                        </div>
                        <div class="card-footer">
                            <form action="book/delete/${book.id}">
                                <button type="submit" class="btn btn-primary">Delete</button>
                            </form>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</@main.layout>