<#import "../layout.ftlh" as main>
<@main.layout>
    <div class="container text-center">
        <div class="center mt-3 mb-3">
            <a type="button" class="btn btn-primary" style="padding: 10px 50px" href="/reader/create">Create</a>
        </div>
        <div class="row">
            <#list readers as reader>
                <div class="col m-2">
                    <div class="card" style="width: 18rem; min-height: 200px">
                        <div class="card-header">
                            <h5 class="card-title">${reader.name}</h5>
                        </div>
                        <div class="card-body">
                            <p class="card-text">Number: ${reader.number}</p>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</@main.layout>