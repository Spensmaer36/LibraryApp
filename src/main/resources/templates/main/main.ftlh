<#import "../layout.ftlh" as main>
<@main.layout>
    <div class="container text-center">
        <div class="row">
            <#list books as book>
                <div class="col m-2">
                    <div class="card" style="width: 18rem; min-height: 200px">
                        <div class="card-header">
                            <h5 class="card-title">${book.name}</h5>
                        </div>
                        <div class="card-body">
                            <p class="card-text"> ${book.description}</p>
                            <p class="card-text">Author: ${author.getAuthorById(book.authorId).name} ${author.getAuthorById(book.authorId).surname}</p>
                            <p class="card-text">Release Date: ${book.releaseDate}</p>
                        </div>
                        <div class="card-footer">
                            <p class="card-text">State: ${state.getStateDtoById(book.stateId).state}</p>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</@main.layout>