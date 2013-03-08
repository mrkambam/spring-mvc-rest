/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nebhale.letsmakeadeal.web;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.nebhale.letsmakeadeal.Game;

@Component
final class GameResourceAssembler extends ResourceAssemblerSupport<Game, GameResource> {

    GameResourceAssembler() {
        super(GamesController.class, GameResource.class);
    }

    public GameResource toResource(Game game) {
        
    	GameResource resource = createResource(game);
        resource.status = game.getStatus();
        
    	// doors = /games/{gameId}/doors
        Link doorsLink = ControllerLinkBuilder.linkTo(GamesController.class).slash(game).slash("doors").withRel("doors");
		resource.add(doorsLink);
        
        return resource;
    }

}
